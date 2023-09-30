create libs directory
mkdir lib target

downloads libs
curl -o lib/jcommander-1.82.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.82/jcommander-1.82.jar
curl -o lib/JCDP-4.0.2.jar https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.2/JCDP-4.0.2.jar

extract libs var.1
            cd target && \
            jar -xf ../lib/JCDP-4.0.2.jar && \
            jar -xf ../lib/jcommander-1.82.jar && \
            rm -rf META-INF && \
            cd ..

extract libs var.2
            unzip -d target lib/JCDP-4.0.2.jar && \
            YES | unzip -d target lib/jcommander-1.82.jar && \
            rm -rf target/META-INF



to create target
javac -cp target -d target src/java/edu/school21/printer/app/*.java src/java/edu/school21/printer/logic/*.java

copy directory resource to target
cp -r src/resources target

create an archive jar
jar -cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

run application
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN

to delete target
rm -rf target lib

