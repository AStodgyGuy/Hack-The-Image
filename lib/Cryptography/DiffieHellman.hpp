#pragma once

// Usage:
// For user A, B initiate class, (on their respective clients), using server 
// defined base and modulus (need to be same on both clients) 
// For both users, Randomly select an a, and call getIntermediateKey with that a.
// Send over the intermediate keys.
// Call getFinalKey with the received keys

class DiffieHellman
{
public:
    DiffieHellman(int base, int modulus);

    const int g; // base
    const int p; // mod

    int getIntermediateKey(int a);

    int getFinalKey(int B);

private:
    int priv;
    int mod_exp(int base, int exponent, int mod);
};
