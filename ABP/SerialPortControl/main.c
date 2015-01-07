#include <stdio.h>			// Standard input/output definitions
#include <string.h>  		// String function definitions
#include <unistd.h>  		// UNIX standard function definitions
#include <fcntl.h>   		// File control definitions
#include <errno.h>   		// Error number definitions
#include <stdlib.h>
#include "SerialPinInfo.h"
#include "SerialPort.h"	
#include "Test.h"

void mainMenu();
void handleMainMenu(char scanner);
void setupPortsMenu();
void handleSetupPortsMenu(char scanner);

int main(int argc, char **argv) {
	printf("Serial Port Controller\n\n");
	
	mainMenu();	
	
	return 0;
}	
void mainMenu() {
	printf("\nMain Menu:\n");	
	printf("\n1. Setup ports\n");
	printf("2. Something\n");
	printf("\nq. Quit\n");
	printf("\nh. Help\n\n->");
	
	char scanner;
	scanf("%c%*c", &scanner);	
	handleMainMenu(scanner);
}
void handleMainMenu(char scanner) {	
	switch(scanner) {
		case '1':
			setupPortsMenu();
			break;
		case '2':
			test();
			break;
		case 'q':
			exit(0);
			break;
		case 'h':
			serialPinInfo();
			break;
		default:
			printf("ERROR! Must enter correct choice!");
			mainMenu();
			break;
	}
	mainMenu();
}
void setupPortsMenu() {
	printf("\nSetup Ports Menu:\n");
	printf("\n1. Open port\n");
	printf("2. Close port\n");
	printf("3. Something\n");
	printf("\nb. Main menu\n");
	printf("\nq. Quit\n");
	printf("\nh. Help\n\n->");	
	
	char scanner;
	scanf("%c%*c", &scanner);
	printf("##########-%c-##########\n", scanner);
	handleSetupPortsMenu(scanner);
}
void handleSetupPortsMenu(char scanner) {
	switch(scanner) {
		case '1':
			openPort();
			break;
		case '2':
			closePort();
			break;
		case '3':
			test();
			break;
		case 'b':
			mainMenu();
			break;
		case 'q':
			exit(0);
			break;
		case 'h':
			serialPinInfo();
			break;
		default:
			printf("ERROR! Must enter correct choice!");
			setupPortsMenu();
			break;
	}
	setupPortsMenu();
}
