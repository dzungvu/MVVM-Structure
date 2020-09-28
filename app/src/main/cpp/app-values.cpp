#include <jni.h>
#include <string>

static const char encKey[] = "This is a secret key";
static const char apiUrlProduct[] = "http://gateway.marvel.com/";
static const char apiUrlDev[] = "http://gateway.marvel.com/";
static const char publicKey[] = "35a902600aab81e4e369faa17dfcc69a";
static const char privateKey[] = "a42649460cc88ecd7940a2890f74653dfdb6e6df";

extern "C" JNIEXPORT jstring
JNICALL
Java_com_thedung_mvvmstructure_di_module_NetworkModule_getBaseUrl(JNIEnv *env, jobject thiz, jboolean debug) {
    if (debug)
        if (debug)
            return env->NewStringUTF(apiUrlDev);
        return env->NewStringUTF(apiUrlProduct);
}

extern "C" JNIEXPORT jstring
JNICALL
Java_com_thedung_mvvmstructure_di_module_NetworkModule_getPublicKeyFromEx(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(publicKey);
}

extern "C" JNIEXPORT jstring
JNICALL
Java_com_thedung_mvvmstructure_di_module_NetworkModule_getPrivateKeyFromEx(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(privateKey);
}