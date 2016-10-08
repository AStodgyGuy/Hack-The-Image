#include <stdio.h>
//#include <ws2tcpip.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>
#include <stdlib.h>

#pragma comment(lib, "Ws2_32.lib")
#define DEFAULT_PORT 10000

using namespace std;

/*
inititlise socket
bind socket
listen on socket
accept connection
send/recieve data
disconnect
*/


class Server {
    //SOCKET listener = INVALID_SOCKET;
    int listener;
    sockaddr_in addr;
public:
    int listenOnPort(int port);
    void closeConnection(void);
    sockaddr_in getAddrInfo(void);
    int getListener(void);
};

int Server::listenOnPort(int port) {
    /*** WINDOWS
    //initilise socket
    WSADATA wsaData;
    wsaStart = WSAStartup(MAKEWORD(2,2), &wsaData);

    if (wsaStart != 0) {
        cout << "WSAStartup failed: " + wsaStart;
        return false;        
    }***/

    //addr info    
    addr.sin_family = AF_INET;
    addr.sin_port = htons(port);
    addr.sin_addr.s_addr = htonl(INADDR_ANY);

    //instantiate socket
    listener = socket(AF_INET, SOCK_STREAM, 6);

    if (listener < 0) {
        printf("Failed to instantiate Socket: ");
        return -1;        
    }

    //bind socket
    if (bind(listener, (sockaddr *) &addr, sizeof(addr)) < 0) {
        printf("Could not bind");
        return -1;
    }

    //listen
    listen(listener, SOMAXCONN);

    //closeConnection();
}

//close connection
void Server::closeConnection(void) {
    if (listener) {
        shutdown(listener, 2); //stops reception and transmission
    }

    //WSACleanup();
}

//get address info
sockaddr_in Server::getAddrInfo(void) {
    return addr;
}

//get Socket
int Server::getListener(void) {
    return listener;
}

void createSocketToSend(char imageSize[], char imageArray[]) {
    Server server;

    int socket;
    int listenening;
    sockaddr_in info;
    socklen_t infoLength;

    int writeImage;
    int writeImageSize;
    int readDesc;

    listenening = server.listenOnPort(10001); 
    if (listenening < 0) {
        server.closeConnection();
        printf("waiting for receiver...");
    }

    info = server.getAddrInfo();
    infoLength = sizeof(info);
    socket = server.getListener();

    readDesc = accept(socket, (sockaddr *) &info, &infoLength);

    writeImageSize = write(readDesc, imageSize, 4);
    writeImage = write(readDesc, imageArray, 255);
    if (write < 0) {
        server.closeConnection();
        printf("Error When writing");
    }

    server.closeConnection();
}

//thread method
void process(int readDesc) {
    int readOutputSize;
    int readOutputImage;    
    int imageSize;
    char imageSizeBuffer[4];    

    readOutputSize = read(readDesc, imageSizeBuffer, 4);      
    if (readOutputSize < 0) {
        printf("Error When reading 1");
    }  
    
    int j = 12;
    for(int i = 0; i < 4; i++) {
        imageSize = imageSize + (int) imageSizeBuffer[i] << j;
        j = j-4;
    }

    char imageArray[imageSize];
    readOutputImage = read(readDesc, imageArray, 255);
    if (readOutputImage < 0) {
        printf("Error When reading 2");
    }    
    
    createSocketToSend(imageSizeBuffer, imageArray);
}

int main() {
    Server server;

    int socket;
    int listenening;
    sockaddr_in info;
    socklen_t infoLength;

    int pid;
    int readDesc;

    int readOutputSize;
    int readOutputImage;    
    int imageSize;
    char imageSizeBuffer[4];

    listenening = server.listenOnPort(DEFAULT_PORT); 
    if (listenening < 0) {
        server.closeConnection();
        printf("waiting for connection...");
    }

    info = server.getAddrInfo();
    infoLength = sizeof(info);
    socket = server.getListener();
    
    //while(true) {
        readDesc = accept(socket, (sockaddr *) &info, &infoLength);

        if(readDesc < 0) {
            server.closeConnection();
            printf("Error when accepting");
        }
        else {
            printf("connected\n");
            //process(readDesc);
            //pid = fork();
            
            /*if(pid < 0) {
                printf("error on fork");
            } else if (pid == 0) {
                server.closeConnection();
                process(readDesc);
                exit(0);
            } else {
                server.closeConnection();
            } */                          

            readOutputSize = read(readDesc, imageSizeBuffer, 4);      
            if (readOutputSize < 0) {
                printf("Error When reading 1");
            }  

            int j = 12;
            for(int i = 0; i < 4; i++) {
                imageSize = imageSize + (int) imageSizeBuffer[i] << j;
                j = j-4;
            }

            char *imageArray = (char *)malloc(imageSize);
            readOutputImage = read(readDesc, imageArray, 255);
            if (readOutputImage < 0) {
                printf("Error When reading 2");
            }
            
            createSocketToSend(imageSizeBuffer, imageArray);
            free(imageArray);
        }
    //}

    server.closeConnection();
}