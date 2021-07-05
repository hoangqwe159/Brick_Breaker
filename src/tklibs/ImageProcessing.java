package tklibs;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessing {
    public ImageProcessing() {
    }

    public static BufferedImage scaleImage(BufferedImage image, float scaleWidth, float scaleHeight) {
        return ImageProcessing.scaleImage(image, Math.round(image.getWidth() * scaleWidth), Math.round(image.getHeight() * scaleHeight));
    }

    public static BufferedImage scaleImage(BufferedImage image, float scaleFactor) {
        return ImageProcessing.scaleImage(image, Math.round(image.getWidth() * scaleFactor), Math.round(image.getHeight() * scaleFactor));
    }

    public static BufferedImage scaleImage(BufferedImage image, int newWidth, int newHeight) {
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, 7);
        Graphics2D graphics2D = scaledImage.createGraphics();
        if (newWidth * newHeight > image.getWidth() * image.getHeight()) {
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        }
        else {
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        }
        graphics2D.drawImage(image, 0, 0, scaledImage.getWidth(), scaledImage.getHeight(), null);
        graphics2D.dispose();
        return scaledImage;
    }

    public BufferedImage continuousVerticalBlendImage(BufferedImage base, BufferedImage overlay, int xb, int yb, int widthb, int heightb, int xo, int yo, int widtho, int heighto, int continuity, int mode) {
        int pieceHeightSrc = heighto / continuity;
        int pieceHeightDes = heightb / continuity;
        double factorStep = (double)1 / (continuity - 1);
        if (mode == -1) {
            for (int i = 0; i < continuity / 2; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float) (1 - factorStep * 2 * i));
            }
            for (int i = continuity / 2; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float) (factorStep * 2 * i));
            }
        }
        if (mode == 0) {
            for (int i = 0; i < continuity / 2; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(factorStep * 2* i));
            }
            for (int i = continuity / 2; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(1 - factorStep * 2 * i));
            }
        }
        else if (mode == 1) {
            for (int i = 0; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(1 - factorStep * i));
            }
        }
        else if (mode == 2) {
            for (int i = 0; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(factorStep * i));
            }
        }
        return base;
    }

    public BufferedImage blendImage(BufferedImage base, BufferedImage overlay, int xb1, int yb1, int xb2, int yb2, int xo1, int yo1, int xo2, int yo2, float factor) {
        Graphics2D graphics2D = base.createGraphics();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(factor));
        graphics2D.drawImage(overlay, xb1, yb1, xb2, yb2, xo1, yo1, xo2, yo2, null);
        graphics2D.dispose();
        return base;
    }
}
