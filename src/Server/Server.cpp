#include <stdio.h>
//#include <ws2tcpip.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

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

    public: 
        bool listenOnPort(void);
        void closeConnection();

};

bool Server::listenOnPort(void) {
    /*** WINDOWS
    //initilise socket
    WSADATA wsaData;
    wsaStart = WSAStartup(MAKEWORD(2,2), &wsaData);

    if (wsaStart != 0) {
        cout << "WSAStartup failed: " + wsaStart;
        return false;        
    }***/

    //addr info
    sockaddr_in addr;
    addr.sin_family = AF_INET;
    addr.sin_port = htons(DEFAULT_PORT);
    addr.sin_addr.s_addr = htonl(INADDR_ANY);

    //instantiate socket
    listener = socket(AF_INET, SOCK_STREAM, 6);

    if (listener < 0) {
        printf("Failed to instantiate Socket: ");
        return false;        
    }

    //bind socket
    if (bind(listener, (sockaddr *) &addr, sizeof(addr)) < 0) {
        printf("Could not bind");
        return false;
    }

    //listen
    listen(listener, SOMAXCONN);

    closeConnection();
}

//close connection
void Server::closeConnection(void) {
    if (listener) {
        shutdown(listener, 2); //stops reception and transmission
    }

    //WSACleanup();
}

int main() {
    
}