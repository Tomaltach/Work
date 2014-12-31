#include <stdio.h>   // Standard input/output definitions
#include <string.h>  // String function definitions
#include <unistd.h>  // UNIX standard function definitions
#include <fcntl.h>   // File control definitions
#include <errno.h>   // Error number definitions

int open_port(char port) {
	//printf(port + "\n");
	int ports = 0;
	printf("Port: ");
	scanf("%d", &ports);
	
	return ports;
}