#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<stdlib.h>
#include<string.h>
int main(int argc, char** argv){

        pid_t pid0, pid1, pid2, pid3, pid4;

       // stdin::cout << "Parent is " << getpid() << stdin::endl;
        printf("Parent is %d\n", getpid());

        printf("Value in argv[1] is");
        printf("%s",argv[1]);
        printf("\n");
        if(strchr(argv[1], 'a') != NULL){

                for(int i = 0; i < 3; i++){
                        if(fork() == 0){
                                exit(0);
                        }
                }
        }
        //printf("Typpe pstree -p %d\n", getpid());
        //sleep(60);
        else if(strchr(argv[1], 'b') != NULL){

        }

        else if(strchr(argv[1], 'c') != NULL){

        }

        sleep(100);
}

~                                                                                                                                                                                                          
~                                                                                                                                                                                                          
~                                   
