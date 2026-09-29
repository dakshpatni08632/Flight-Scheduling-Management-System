@echo off
if exist out rmdir /s /q out
mkdir out
for /R src %%f in (*.java) do echo %%f >> sources.txt
javac -d out @sources.txt
del sources.txt
java -cp out com.flight.flights.Main
pause
