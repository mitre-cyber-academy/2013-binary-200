Name: Debuggers are overrated!
Description: A user will be provided with a jar file which is executable, and will tell the user "Good Job" when they have provided the right key. The user will need to extract the jar file and decompile the java class. Upon decompilation they will find an MD5 hash of the key. Upon more digging they will find the manifest contains the beginning of the real key. They will then need to write a script (similar to the solver included) in order to find out the MD5.

To Build: 

javac Overrated.java && jar cvfm Overrated.jar manifest.txt Overrated.class

Files distributed: dist/Overrated.jar

Flag: MCA-8EC28E12