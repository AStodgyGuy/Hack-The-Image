#include "AES.hpp"

#include <vector>

using std::string;
using std::vector;


string pad(string str, int size)
{

    while (str.length() % size != 0)
    {
        str.push_back('1');
    }

    return str;
}

std::string AES::Encrypt(std::string message, std::string key)
{
    message = pad(message, 17);
    CRijndael ciph;
    ciph.MakeKey(key.c_str(), CRijndael::sm_chain0, 16, 16);
    char dataOut[message.length()];
    char dataIn[message.length()];
    const char* dataIn1 = message.c_str() ;
 
    memset(dataIn, 0, message.length());
    memset(dataOut, 0, message.length());
    
    strcpy(dataIn, dataIn1);
    memset(dataOut, 0, message.length());
    ciph.Encrypt(dataIn, dataOut, message.length() - 1, CRijndael::ECB);

    return dataOut;
}

std::string AES::Decrypt(std::string ciphered, std::string key)
{
    CRijndael ciph;
    ciph.MakeKey(key.c_str(), CRijndael::sm_chain0, 16, 16);
    char dataOut[ciphered.length()];
    char dataIn[ciphered.length()];
    const char* dataIn1 =  ciphered.c_str() ;
 
    memset(dataIn, 0, ciphered.length());
    memset(dataOut, 0, ciphered.length());
    
    strcpy(dataIn, dataIn1);
    memset(dataOut, 0, ciphered.length());
    ciph.Decrypt(dataIn, dataOut, ciphered.length(), CRijndael::ECB);

    return dataOut; 
}
