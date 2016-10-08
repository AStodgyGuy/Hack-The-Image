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
};
