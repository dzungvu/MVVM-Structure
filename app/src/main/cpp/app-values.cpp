#include <jni.h>
#include <string>

static const char encKey[] = "This is a secret key";
static const char apiUrlProduct[] = "https://5f20e5efdaa42f001666512d.mockapi.io/api/v1/";
static const char apiUrlDev[] = "https://5f20e5efdaa42f001666512d.mockapi.io/api/v1/";

extern "C" JNIEXPORT jstring

JNICALL
Java_com_thedung_mvvmstructure_di_module_NetworkModule_getBaseUrl(JNIEnv *env, jobject thiz, jboolean debug) {
    if (debug)
        if (debug)
            return env->NewStringUTF(apiUrlDev);
        return env->NewStringUTF(apiUrlProduct);
}