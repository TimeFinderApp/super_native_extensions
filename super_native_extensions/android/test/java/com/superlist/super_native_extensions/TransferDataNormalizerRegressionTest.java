package com.superlist.super_native_extensions;

public final class TransferDataNormalizerRegressionTest {
    public static void main(String[] args) {
        normalizeConvertsCharSequenceToString();
        normalizeLeavesBinaryDataUntouched();
        normalizeAllowsNull();
    }

    private static void normalizeConvertsCharSequenceToString() {
        Object normalized = TransferDataNormalizer.normalize(new CustomCharSequence("Dragged text"));

        assert normalized instanceof String : "Expected String, got " + normalized;
        assert "Dragged text".equals(normalized) : "Unexpected text: " + normalized;
    }

    private static void normalizeLeavesBinaryDataUntouched() {
        byte[] data = new byte[] {1, 2, 3};
        Object normalized = TransferDataNormalizer.normalize(data);

        assert normalized == data : "Expected byte[] reference to be preserved";
    }

    private static void normalizeAllowsNull() {
        assert TransferDataNormalizer.normalize(null) == null : "Expected null to stay null";
    }

    private static final class CustomCharSequence implements CharSequence {
        private final String value;

        private CustomCharSequence(String value) {
            this.value = value;
        }

        @Override
        public int length() {
            return value.length();
        }

        @Override
        public char charAt(int index) {
            return value.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return value.subSequence(start, end);
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
