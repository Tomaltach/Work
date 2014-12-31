#include <stdio.h>			// Standard input/output definitions
#include "SerialPinInfo.h"
#include "OpenSerialPort.h"	
#include "Test.h"

int main(int argc, char **argv) {
	printf("Serial Port Controller\n\n");	
	serialPinInfo();
	
	printf("\n\n");
	
	//int port = open_port("COM 1");
	//printf("%d", port);
	
	//printf("\n");
	
	test();
	
	return 0;
}
