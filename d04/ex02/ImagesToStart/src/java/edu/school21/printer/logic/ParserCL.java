package edu.school21.printer.logic;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.JCommander;

@Parameters(separators = "=")
public class ParserCL {

    @Parameter(names = {"--white"})
    private String  white;
    @Parameter(names = {"--black"})
    private String  black;

    public String getWhite() {
        return white;
    }

    public String getBlack() {
        return black;
    }

    public void commandLineParser (String[] args) {
        JCommander.newBuilder().addObject(this).build().parse(args);
    }
}