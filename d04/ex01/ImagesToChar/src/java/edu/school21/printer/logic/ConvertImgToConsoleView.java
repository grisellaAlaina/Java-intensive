package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ConvertImgToConsoleView {
    private final char white;
    private final char black;
    private final String pathToImg;

    public ConvertImgToConsoleView(String[] args, String pathToImg) {
        String[] parsedArgs = parseArgs(args);
        this.white = parsedArgs[0].charAt(0);
        this.black = parsedArgs[1].charAt(0);
        this.pathToImg = Paths.get(pathToImg).toAbsolutePath().normalize().toString();
    }

    private String[] parseArgs(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments. Expecting 3 arguments: white_symbol, black_symbol, path_to_img");
        }

        return args;
    }

    public void convertAndOutputInConsole() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(pathToImg));
        BufferedImage scaledImage = convertToConsoleAspectRatio(bufferedImage);
        BufferedImage binaryImage = new BufferedImage(scaledImage.getWidth(), scaledImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);

        Graphics2D g2d = binaryImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();
        printImgInConsole(binaryImage);
    }

    private BufferedImage convertToConsoleAspectRatio(BufferedImage sourceImage) {
        double scaleFactor = 1;
        int newWidth = (int) (sourceImage.getWidth() * scaleFactor);
        int newHeight = (int) (sourceImage.getHeight() * scaleFactor);

        BufferedImage consoleImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_BYTE_INDEXED);

        Graphics2D g2d = consoleImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(sourceImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return consoleImage;
    }

    private void printImgInConsole(BufferedImage image) {
        int blackColor = 0xFF000000;

        for (int i = 0; i < image.getHeight(); ++i) {
            for (int j = 0; j < image.getWidth(); ++j) {
                int color = image.getRGB(j, i);
                if (color == blackColor) {
                    System.out.print(black);
                } else {
                    System.out.print(white);
                }
            }
            System.out.println();
        }
    }
}