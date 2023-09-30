package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.FColor;


public class ConvertImgToConsoleView {

    private final String  white;

    private final String  black;
    private final String  pathToImg;

    public ConvertImgToConsoleView(ParserCL pcl, String pathToImg) {
        this.white = pcl.getWhite();
        this.black = pcl.getBlack();
        this.pathToImg = Paths.get(pathToImg).toAbsolutePath().normalize().toString();
    }

    public void convertAndOutputInConsole() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File((pathToImg)));

        int height = bufferedImage.getHeight();
        int width = bufferedImage.getWidth();

        printImg(height, width, bufferedImage);
    }

    private void  printImg(int height, int width, BufferedImage bi) {
        ColoredPrinter foreground =
                new ColoredPrinter.Builder(1, false).foreground(FColor.valueOf(black)).build();

        ColoredPrinter background =
                new ColoredPrinter.Builder(1, false).foreground(FColor.valueOf(white)).build();
        int blackColor = 0xFF000000;

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int color = bi.getRGB(j, i);
                if (color == blackColor) {
                    foreground.print('\u2588');
                } else {
                    background.print('\u2588');
                }
            }
            System.out.println();
        }
    }
}