#include <stdio.h>   // Standard input/output definitions
#include <string.h>  // String function definitions
#include <windows.h>

#define MAX_LENGTH 8

// Declare variables and structures
HANDLE hSerial;

void openPort() {
	char str_port[MAX_LENGTH] = "";
	printf("Enter Port Name: ");
	scanf("%s", str_port);
	char str_portname[MAX_LENGTH] = "\\\\.\\";
	strcat(str_portname, str_port);

	// Open the highest available serial port number
    fprintf(stderr, "Opening serial port...");
    hSerial = CreateFile(
                str_portname, GENERIC_READ|GENERIC_WRITE, 0, 0,
                OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, 0);
    if (hSerial == INVALID_HANDLE_VALUE) {
            fprintf(stderr, "Error\n");
    } else {
		fprintf(stderr, "OK\n");
	}
}
void closePort() {
	char str_port[MAX_LENGTH] = "";
	printf("Enter Port Name: ");
	scanf("%s", str_port);
	char str_portname[MAX_LENGTH] = "\\\\.\\";
	strcat(str_portname, str_port);
	int i;
	for(i=0; str_portname[i]!='\0'; i++) {
		if(str_portname[i]=='\n') {
			str_portname[i]=' ';
		}
	}
	
	/*
	fgets(str_port, sizeof(str_port), stdin);
		
	strcat(str_portname, str_port);
	*/
	
	// Close serial port
    fprintf(stderr, "Closing serial port...");
    if (CloseHandle(hSerial) == 0) {
        fprintf(stderr, "Error\n");
    }
    fprintf(stderr, "OK\n");
}