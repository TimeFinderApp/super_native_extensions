package com.superlist.super_native_extensions;

final class TransferDataNormalizer {
    private TransferDataNormalizer() {}

    static Object normalize(Object data) {
        if (data instanceof CharSequence) {
            return data.toString();
        }
        return data;
    }
}
