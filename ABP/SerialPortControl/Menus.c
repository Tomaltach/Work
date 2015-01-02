#include <stdio.h>	// Standard input/output definitions

char main_menu() {
	printf("\n1. Setup Ports\n");
	printf("2. Something\n");
	printf("\nq. Quit\n");
	printf("\nh. Help\n\n->");
	
	char input;
	scanf("%c", &input);
	
	return input;
}