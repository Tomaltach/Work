##
## Auto Generated makefile by CodeLite IDE
## any manual changes will be erased      
##
## Debug
ProjectName            :=SerialPortControl
ConfigurationName      :=Debug
WorkspacePath          := "C:\Users\tdonegan\git\Work\ABP\SerialPortControl"
ProjectPath            := "C:\Users\tdonegan\git\Work\ABP\SerialPortControl"
IntermediateDirectory  :=./Debug
OutDir                 := $(IntermediateDirectory)
CurrentFileName        :=
CurrentFilePath        :=
CurrentFileFullPath    :=
User                   :=tdonegan
Date                   :=12/31/14
CodeLitePath           :="C:\Program Files (x86)\CodeLite"
LinkerName             :=C:/MinGW-4.8.1/bin/g++.exe 
SharedObjectLinkerName :=C:/MinGW-4.8.1/bin/g++.exe -shared -fPIC
ObjectSuffix           :=.o
DependSuffix           :=.o.d
PreprocessSuffix       :=.i
DebugSwitch            :=-g 
IncludeSwitch          :=-I
LibrarySwitch          :=-l
OutputSwitch           :=-o 
LibraryPathSwitch      :=-L
PreprocessorSwitch     :=-D
SourceSwitch           :=-c 
OutputFile             :=$(IntermediateDirectory)/$(ProjectName)
Preprocessors          :=
ObjectSwitch           :=-o 
ArchiveOutputSwitch    := 
PreprocessOnlySwitch   :=-E
ObjectsFileList        :="SerialPortControl.txt"
PCHCompileFlags        :=
MakeDirCommand         :=makedir
RcCmpOptions           := 
RcCompilerName         :=C:/MinGW-4.8.1/bin/windres.exe 
LinkOptions            :=  
IncludePath            :=  $(IncludeSwitch). $(IncludeSwitch). 
IncludePCH             := 
RcIncludePath          := 
Libs                   := 
ArLibs                 :=  
LibPath                := $(LibraryPathSwitch). 

##
## Common variables
## AR, CXX, CC, AS, CXXFLAGS and CFLAGS can be overriden using an environment variables
##
AR       := C:/MinGW-4.8.1/bin/ar.exe rcu
CXX      := C:/MinGW-4.8.1/bin/g++.exe 
CC       := C:/MinGW-4.8.1/bin/gcc.exe 
CXXFLAGS :=  -g -O0 -Wall $(Preprocessors)
CFLAGS   :=  -g -O0 -Wall $(Preprocessors)
ASFLAGS  := 
AS       := C:/MinGW-4.8.1/bin/as.exe 


##
## User defined environment variables
##
CodeLiteDir:=C:\Program Files (x86)\CodeLite
UNIT_TEST_PP_SRC_DIR:=C:\UnitTest++-1.3
Objects0=$(IntermediateDirectory)/main.c$(ObjectSuffix) $(IntermediateDirectory)/SerialPinInfo.c$(ObjectSuffix) $(IntermediateDirectory)/OpenSerialPort.c$(ObjectSuffix) $(IntermediateDirectory)/Test.c$(ObjectSuffix) 



Objects=$(Objects0) 

##
## Main Build Targets 
##
.PHONY: all clean PreBuild PrePreBuild PostBuild
all: $(OutputFile)

$(OutputFile): $(IntermediateDirectory)/.d $(Objects) 
	@$(MakeDirCommand) $(@D)
	@echo "" > $(IntermediateDirectory)/.d
	@echo $(Objects0)  > $(ObjectsFileList)
	$(LinkerName) $(OutputSwitch)$(OutputFile) @$(ObjectsFileList) $(LibPath) $(Libs) $(LinkOptions)

$(IntermediateDirectory)/.d:
	@$(MakeDirCommand) "./Debug"

PreBuild:


##
## Objects
##
$(IntermediateDirectory)/main.c$(ObjectSuffix): main.c $(IntermediateDirectory)/main.c$(DependSuffix)
	$(CC) $(SourceSwitch) "C:/Users/tdonegan/git/Work/ABP/SerialPortControl/main.c" $(CFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/main.c$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/main.c$(DependSuffix): main.c
	@$(CC) $(CFLAGS) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/main.c$(ObjectSuffix) -MF$(IntermediateDirectory)/main.c$(DependSuffix) -MM "main.c"

$(IntermediateDirectory)/main.c$(PreprocessSuffix): main.c
	@$(CC) $(CFLAGS) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/main.c$(PreprocessSuffix) "main.c"

$(IntermediateDirectory)/SerialPinInfo.c$(ObjectSuffix): SerialPinInfo.c $(IntermediateDirectory)/SerialPinInfo.c$(DependSuffix)
	$(CC) $(SourceSwitch) "C:/Users/tdonegan/git/Work/ABP/SerialPortControl/SerialPinInfo.c" $(CFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/SerialPinInfo.c$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/SerialPinInfo.c$(DependSuffix): SerialPinInfo.c
	@$(CC) $(CFLAGS) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/SerialPinInfo.c$(ObjectSuffix) -MF$(IntermediateDirectory)/SerialPinInfo.c$(DependSuffix) -MM "SerialPinInfo.c"

$(IntermediateDirectory)/SerialPinInfo.c$(PreprocessSuffix): SerialPinInfo.c
	@$(CC) $(CFLAGS) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/SerialPinInfo.c$(PreprocessSuffix) "SerialPinInfo.c"

$(IntermediateDirectory)/OpenSerialPort.c$(ObjectSuffix): OpenSerialPort.c $(IntermediateDirectory)/OpenSerialPort.c$(DependSuffix)
	$(CC) $(SourceSwitch) "C:/Users/tdonegan/git/Work/ABP/SerialPortControl/OpenSerialPort.c" $(CFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/OpenSerialPort.c$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/OpenSerialPort.c$(DependSuffix): OpenSerialPort.c
	@$(CC) $(CFLAGS) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/OpenSerialPort.c$(ObjectSuffix) -MF$(IntermediateDirectory)/OpenSerialPort.c$(DependSuffix) -MM "OpenSerialPort.c"

$(IntermediateDirectory)/OpenSerialPort.c$(PreprocessSuffix): OpenSerialPort.c
	@$(CC) $(CFLAGS) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/OpenSerialPort.c$(PreprocessSuffix) "OpenSerialPort.c"

$(IntermediateDirectory)/Test.c$(ObjectSuffix): Test.c $(IntermediateDirectory)/Test.c$(DependSuffix)
	$(CC) $(SourceSwitch) "C:/Users/tdonegan/git/Work/ABP/SerialPortControl/Test.c" $(CFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/Test.c$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/Test.c$(DependSuffix): Test.c
	@$(CC) $(CFLAGS) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/Test.c$(ObjectSuffix) -MF$(IntermediateDirectory)/Test.c$(DependSuffix) -MM "Test.c"

$(IntermediateDirectory)/Test.c$(PreprocessSuffix): Test.c
	@$(CC) $(CFLAGS) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/Test.c$(PreprocessSuffix) "Test.c"


-include $(IntermediateDirectory)/*$(DependSuffix)
##
## Clean
##
clean:
	$(RM) ./Debug/*$(ObjectSuffix)
	$(RM) ./Debug/*$(DependSuffix)
	$(RM) $(OutputFile)
	$(RM) $(OutputFile).exe
	$(RM) ".build-debug/SerialPortControl"


