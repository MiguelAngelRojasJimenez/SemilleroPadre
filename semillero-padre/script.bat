@echo off
::Realizado por: Javier Arias
echo "*****SCRIPT******"
start cmd /k mvn clean install
echo Si el proyecto compilo con exito, presiona cualquier tecla...
pause >nul
cd /D "C:\Program Files\wildfly-15.0.1.Final\standalone\deployments"
echo Limpiando directorio...
del /F /S /Q *.ear
del /F /S /Q *.deployed
echo Copiando .ear
xcopy D:\Semillero\clase2\semillero-hbt\semillero-padre\semillero-ear\target "C:\Program Files\wildfly-15.0.1.Final\standalone\deployments"  
echo Ejecutando .bat
cd /D "C:\Program Files\wildfly-15.0.1.Final\bin\"  
call standalone.bat
pause
:exit
