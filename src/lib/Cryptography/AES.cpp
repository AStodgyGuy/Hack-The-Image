#include "AES.hpp"

#include <vector>

using std::string;
using std::vector;


vector<string> split_string(string str, int size)
{
    vector<string> strings{};

    while (str.size() % 16 != 0)
    {
        str.push_back('\0');
    }

    for (int i = 0; i + 16 < str.size(); i += 16)
    {
        strings.push_back(str.substr(i, i + 15));
    }
    return strings;
}

std::string AES::Encrypt(std::string message, std::string key)
{
    vector<string> toEncrypt = split_string(message, 16);
    CRijndael ciph;
    ciph.MakeKey(key.c_str(), CRijndael::sm_chain0, 16, 16);
    string ciphered = "";
    for (const auto& x : toEncrypt)
    {
        char out[16 + 1];
        memset(out, 0xff, 16 + 1);
        ciph.EncryptBlock(x.c_str(), out);
        ciphered += string(out);
    }
    return ciphered;
}

std::string AES::Decrypt(std::string ciphered, std::string key)
{
    vector<string> toDecrypt = split_string(ciphered, 16);
    CRijndael ciph;
    ciph.MakeKey(key.c_str(), CRijndael::sm_chain0, 16, 16);
    string plaintext = ""; 
    for (const auto& x : toDecrypt)
    {
        char out[16 + 1];
        memset(out, 0xff, 16+1);
        ciph.DecryptBlock(x.c_str(), out);
        plaintext += string(out);
    }

    return plaintext;

}
