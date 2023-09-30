
to create target
javac -d target src/java/edu/school21/printer/app/*.java src/java/edu/school21/printer/logic/*.java

copy directory resource to target
cp -r src/resources target

create an archive jar
jar -cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

run application
java -jar target/images-to-chars-printer.jar . 0

to delete target
rm -rf target

