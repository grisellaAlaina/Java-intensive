to create target
javac -d target src/java/edu/school21/printer/app/*.java src/java/edu/school21/printer/logic/*.java

to run
java -classpath target edu.school21.printer.app.Program . 0 ../it.bmp

to delete target
rm -rf target

