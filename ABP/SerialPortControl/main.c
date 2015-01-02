#include <stdio.h>			// Standard input/output definitions
#include "SerialPinInfo.h"
#include "OpenSerialPort.h"	
#include "Test.h"
#include "Menus.h"

typedef int bool;
#define TRUE  1
#define FALSE 0

int main(int argc, char **argv) {
	printf("Serial Port Controller\n\n");
	
	char check = "w";
	bool quit = FALSE;
	while(quit == FALSE) {
		if(check == "q") {
			quit = TRUE;
		} else {			
			check = main_menu();
			printf("--------------------------------->%c", check);
		}
	}
		//serialPinInfo();
	
		//printf("\n\n");
	
		//int port = open_port("COM 1");
		//printf("%d", port);
	
		//printf("\n");
	
		test();
	
	return 0;
}
