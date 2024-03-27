$outputDirectory = "out"
# Wenn das Output-Directory existiert, lösche es.
if (Test-Path $outputDirectory) {
  Remove-Item -Recurse -Force $outputDirectory
}

# Der Java Class Path legt fest, in welchen Verzeichnissen
# der Compiler bzw. die Java Runtime nach Packages
# suchen soll. Der Class Path ist eine Liste von
# Pfaden, getrennt durch Semikolons (in Linux/Mac nutzt man : als Trenner).
# Bemerkung: Auch Pfade zu JARs (Java Archives) können hier
# angegeben werden.
# Bemerkung: Der Pfad . bedeutet "aktuelles Arbeitsverzeichnis".
$javaClassPath = ".;$outputDirectory;C:\dev\my-library.jar"

# Kompiliere das Programm und lege die Kompilate im Output-Verzeichnis ab.
javac -d $outputDirectory --class-path $javaClassPath MainApp.java

# Wenn der Compiler keine Fehler festgestellt hat, führen wir unser
# Programm mit dem Java Launcher aus.
if ($? -eq $true) {
  java --class-path $javaClassPath MainApp
}



