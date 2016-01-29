package org.bull.tasks;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.experimental.Accessors;

/**
 * Bull Metadata object.
 * <p>
 * Created by amit on 29/01/16.
 */
@Accessors(prefix = "m")
public class Metadata {

    /* --- Members --- */

    private Bundle mBundle;

    /* --- Constructors --- */

    /**
     * Default constructor used to instantiate a new empty metadata object
     */
    public Metadata() {
        mBundle = new Bundle();
    }

    /**
     * Constructor used to copy metadata.
     *
     * @param metadata - The metadata to initialize this metatdata with.
     */
    public Metadata(Metadata metadata) {
        mBundle = new Bundle(metadata.mBundle);
    }

    /**
     * Consturctor to create metadata using an existing bundle
     *
     * @param bundle - The bundle to use as metadata storage
     */
    protected Metadata(Bundle bundle) {
        mBundle = bundle;
    }

    /* --- Bundle proxy methods --- */

    /**
     * Inserts a byte value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a byte
     */

    public Metadata putByte(@Nullable String key, byte value) {
        mBundle.putByte(key, value);
        return this;
    }

    /**
     * Inserts a char value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a char
     */

    public Metadata putChar(@Nullable String key, char value) {
        mBundle.putChar(key, value);
        return this;
    }

    /**
     * Inserts a short value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a short
     */

    public Metadata putShort(@Nullable String key, short value) {
        mBundle.putShort(key, value);
        return this;
    }

    /**
     * Inserts a float value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a float
     */

    public Metadata putFloat(@Nullable String key, float value) {
        mBundle.putFloat(key, value);
        return this;
    }

    /**
     * Inserts a CharSequence value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a CharSequence, or null
     */

    public Metadata putCharSequence(@Nullable String key, @Nullable CharSequence value) {
        mBundle.putCharSequence(key, value);
        return this;
    }

    /**
     * Inserts a Parcelable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Parcelable object, or null
     */
    public Metadata putParcelable(@Nullable String key, @Nullable Parcelable value) {
        mBundle.putParcelable(key, value);
        return this;
    }

    /**
     * Inserts a Size value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Size object, or null
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Metadata putSize(@Nullable String key, @Nullable Size value) {
        mBundle.putSize(key, value);
        return this;
    }

    /**
     * Inserts a SizeF value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a SizeF object, or null
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Metadata putSizeF(@Nullable String key, @Nullable SizeF value) {
        mBundle.putSizeF(key, value);
        return this;
    }

    /**
     * Inserts an array of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key   a String, or null
     * @param value an array of Parcelable objects, or null
     */
    public Metadata putParcelableArray(@Nullable String key, @Nullable Parcelable[] value) {
        mBundle.putParcelableArray(key, value);
        return this;
    }

    /**
     * Inserts a List of Parcelable values into the mapping of this Bundle,
     * replacing any existing value for the given key.  Either key or value may
     * be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList of Parcelable objects, or null
     */
    public Metadata putParcelableArrayList(@Nullable String key,
                                           @Nullable ArrayList<? extends Parcelable> value) {
        mBundle.putParcelableArrayList(key, value);
        return this;
    }

    /**
     * Inserts a SparceArray of Parcelable values into the mapping of this
     * Bundle, replacing any existing value for the given key.  Either key
     * or value may be null.
     *
     * @param key   a String, or null
     * @param value a SparseArray of Parcelable objects, or null
     */
    public Metadata putSparseParcelableArray(@Nullable String key,
                                             @Nullable SparseArray<? extends Parcelable> value) {
        mBundle.putSparseParcelableArray(key, value);
        return this;
    }

    /**
     * Inserts an ArrayList<Integer> value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList<Integer> object, or null
     */

    public Metadata putIntegerArrayList(@Nullable String key, @Nullable ArrayList<Integer> value) {
        mBundle.putIntegerArrayList(key, value);
        return this;
    }

    /**
     * Inserts an ArrayList<String> value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList<String> object, or null
     */

    public Metadata putStringArrayList(@Nullable String key, @Nullable ArrayList<String> value) {
        mBundle.putStringArrayList(key, value);
        return this;
    }

    /**
     * Inserts an ArrayList<CharSequence> value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an ArrayList<CharSequence> object, or null
     */

    public Metadata putCharSequenceArrayList(@Nullable String key,
                                             @Nullable ArrayList<CharSequence> value) {
        mBundle.putCharSequenceArrayList(key, value);
        return this;
    }

    /**
     * Inserts a Serializable value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Serializable object, or null
     */

    public Metadata putSerializable(@Nullable String key, @Nullable Serializable value) {
        mBundle.putSerializable(key, value);
        return this;
    }

    /**
     * Inserts a byte array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a byte array object, or null
     */

    public Metadata putByteArray(@Nullable String key, @Nullable byte[] value) {
        mBundle.putByteArray(key, value);
        return this;
    }

    /**
     * Inserts a short array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a short array object, or null
     */

    public Metadata putShortArray(@Nullable String key, @Nullable short[] value) {
        mBundle.putShortArray(key, value);
        return this;
    }

    /**
     * Inserts a char array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a char array object, or null
     */

    public Metadata putCharArray(@Nullable String key, @Nullable char[] value) {
        mBundle.putCharArray(key, value);
        return this;
    }

    /**
     * Inserts a float array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a float array object, or null
     */

    public Metadata putFloatArray(@Nullable String key, @Nullable float[] value) {
        mBundle.putFloatArray(key, value);
        return this;
    }

    /**
     * Inserts a CharSequence array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a CharSequence array object, or null
     */

    public Metadata putCharSequenceArray(@Nullable String key, @Nullable CharSequence[] value) {
        mBundle.putCharSequenceArray(key, value);
        return this;
    }

    /**
     * Inserts a Bundle value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a Bundle object, or null
     */
    public Metadata putBundle(@Nullable String key, @Nullable Bundle value) {
        mBundle.putBundle(key, value);
        return this;
    }

    /**
     * Inserts an {@link IBinder} value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     * <p>
     * <p class="note">You should be very careful when using this function.  In many
     * places where Bundles are used (such as inside of Intent objects), the Bundle
     * can live longer inside of another process than the process that had originally
     * created it.  In that case, the IBinder you supply here will become invalid
     * when your process goes away, and no longer usable, even if a new process is
     * created for you later on.</p>
     *
     * @param key   a String, or null
     * @param value an IBinder object, or null
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public Metadata putBinder(@Nullable String key, @Nullable IBinder value) {
        mBundle.putBinder(key, value);
        return this;
    }

    /**
     * Returns the value associated with the given key, or (byte) 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a byte value
     */

    public byte getByte(String key) {
        return mBundle.getByte(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a byte value
     */

    public Byte getByte(String key, byte defaultValue) {
        return mBundle.getByte(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or (char) 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a char value
     */

    public char getChar(String key) {
        return mBundle.getChar(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a char value
     */

    public char getChar(String key, char defaultValue) {
        return mBundle.getChar(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or (short) 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a short value
     */

    public short getShort(String key) {
        return mBundle.getShort(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a short value
     */

    public short getShort(String key, short defaultValue) {
        return mBundle.getShort(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or 0.0f if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a float value
     */

    public float getFloat(String key) {
        return mBundle.getFloat(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a float value
     */

    public float getFloat(String key, float defaultValue) {
        return mBundle.getFloat(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a CharSequence value, or null
     */

    @Nullable
    public CharSequence getCharSequence(@Nullable String key) {
        return mBundle.getCharSequence(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key or if a null
     * value is explicitly associatd with the given key.
     *
     * @param key          a String, or null
     * @param defaultValue Value to return if key does not exist or if a null
     *                     value is associated with the given key.
     * @return the CharSequence value associated with the given key, or defaultValue
     * if no valid CharSequence object is currently mapped to that key.
     */

    public CharSequence getCharSequence(@Nullable String key, CharSequence defaultValue) {
        return mBundle.getCharSequence(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Size value, or null
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public Size getSize(@Nullable String key) {
        return mBundle.getSize(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Size value, or null
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public SizeF getSizeF(@Nullable String key) {
        return mBundle.getSizeF(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Bundle value, or null
     */
    @Nullable
    public Bundle getBundle(@Nullable String key) {
        return mBundle.getBundle(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Parcelable value, or null
     */
    @Nullable
    public <T extends Parcelable> T getParcelable(@Nullable String key) {
        return mBundle.getParcelable(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Parcelable[] value, or null
     */
    @Nullable
    public Parcelable[] getParcelableArray(@Nullable String key) {
        return mBundle.getParcelableArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<T> value, or null
     */
    @Nullable
    public <T extends Parcelable> ArrayList<T> getParcelableArrayList(@Nullable String key) {
        return mBundle.getParcelableArrayList(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a SparseArray of T values, or null
     */
    @Nullable
    public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(@Nullable String key) {
        return mBundle.getSparseParcelableArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a Serializable value, or null
     */

    @Nullable
    public Serializable getSerializable(@Nullable String key) {
        return mBundle.getSerializable(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<String> value, or null
     */

    @Nullable
    public ArrayList<Integer> getIntegerArrayList(@Nullable String key) {
        return mBundle.getIntegerArrayList(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<String> value, or null
     */

    @Nullable
    public ArrayList<String> getStringArrayList(@Nullable String key) {
        return mBundle.getStringArrayList(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an ArrayList<CharSequence> value, or null
     */

    @Nullable
    public ArrayList<CharSequence> getCharSequenceArrayList(@Nullable String key) {
        return mBundle.getCharSequenceArrayList(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a byte[] value, or null
     */

    @Nullable
    public byte[] getByteArray(@Nullable String key) {
        return mBundle.getByteArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a short[] value, or null
     */

    @Nullable
    public short[] getShortArray(@Nullable String key) {
        return mBundle.getShortArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a char[] value, or null
     */

    @Nullable
    public char[] getCharArray(@Nullable String key) {
        return mBundle.getCharArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a float[] value, or null
     */

    @Nullable
    public float[] getFloatArray(@Nullable String key) {
        return mBundle.getFloatArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a CharSequence[] value, or null
     */

    @Nullable
    public CharSequence[] getCharSequenceArray(@Nullable String key) {
        return mBundle.getCharSequenceArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an IBinder value, or null
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Nullable
    public IBinder getBinder(@Nullable String key) {
        return mBundle.getBinder(key);
    }

    /* --- BaseBundle proxy methods --- */


    /**
     * Inserts all mappings from the given PersistableBundle into this BaseBundle.
     *
     * @param bundle a PersistableBundle
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Metadata putAll(PersistableBundle bundle) {
        mBundle.putAll(bundle);
        return this;
    }

    /**
     * Inserts a Boolean value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a boolean
     */
    public Metadata putBoolean(@Nullable String key, boolean value) {
        mBundle.putBoolean(key, value);
        return this;
    }

    /**
     * Inserts an int value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value an int
     */
    public Metadata putInt(@Nullable String key, int value) {
        mBundle.putInt(key, value);
        return this;
    }

    /**
     * Inserts a long value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a long
     */
    public Metadata putLong(@Nullable String key, long value) {
        mBundle.putLong(key, value);
        return this;
    }

    /**
     * Inserts a double value into the mapping of this Bundle, replacing
     * any existing value for the given key.
     *
     * @param key   a String, or null
     * @param value a double
     */
    public Metadata putDouble(@Nullable String key, double value) {
        mBundle.putDouble(key, value);
        return this;
    }

    /**
     * Inserts a String value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a String, or null
     */
    public Metadata putString(@Nullable String key, @Nullable String value) {
        mBundle.putString(key, value);
        return this;
    }

    /**
     * Inserts a boolean array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a boolean array object, or null
     */
    public Metadata putBooleanArray(@Nullable String key, @Nullable boolean[] value) {
        mBundle.putBooleanArray(key, value);
        return this;
    }

    /**
     * Inserts an int array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value an int array object, or null
     */
    public Metadata putIntArray(@Nullable String key, @Nullable int[] value) {
        mBundle.putIntArray(key, value);
        return this;
    }

    /**
     * Inserts a long array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a long array object, or null
     */
    public Metadata putLongArray(@Nullable String key, @Nullable long[] value) {
        mBundle.putLongArray(key, value);
        return this;
    }

    /**
     * Inserts a double array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a double array object, or null
     */
    public Metadata putDoubleArray(@Nullable String key, @Nullable double[] value) {
        mBundle.putDoubleArray(key, value);
        return this;
    }

    /**
     * Inserts a String array value into the mapping of this Bundle, replacing
     * any existing value for the given key.  Either key or value may be null.
     *
     * @param key   a String, or null
     * @param value a String array object, or null
     */
    public Metadata putStringArray(@Nullable String key, @Nullable String[] value) {
        mBundle.putStringArray(key, value);
        return this;
    }

    /**
     * Returns the value associated with the given key, or false if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a boolean value
     */
    public boolean getBoolean(String key) {
        return mBundle.getBoolean(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a boolean value
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        return mBundle.getBoolean(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or 0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return an int value
     */
    public int getInt(String key) {
        return mBundle.getInt(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return an int value
     */
    public int getInt(String key, int defaultValue) {
        return mBundle.getInt(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or 0L if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a long value
     */
    public long getLong(String key) {
        return mBundle.getLong(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a long value
     */
    public long getLong(String key, long defaultValue) {
        return mBundle.getLong(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or 0.0 if
     * no mapping of the desired type exists for the given key.
     *
     * @param key a String
     * @return a double value
     */
    public double getDouble(String key) {
        return mBundle.getDouble(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key.
     *
     * @param key          a String
     * @param defaultValue Value to return if key does not exist
     * @return a double value
     */
    public double getDouble(String key, double defaultValue) {
        return mBundle.getDouble(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a String value, or null
     */
    @Nullable
    public String getString(@Nullable String key) {
        return mBundle.getString(key);
    }

    /**
     * Returns the value associated with the given key, or defaultValue if
     * no mapping of the desired type exists for the given key or if a null
     * value is explicitly associated with the given key.
     *
     * @param key          a String, or null
     * @param defaultValue Value to return if key does not exist or if a null
     *                     value is associated with the given key.
     * @return the String value associated with the given key, or defaultValue
     * if no valid String object is currently mapped to that key.
     */
    public String getString(@Nullable String key, String defaultValue) {
        return mBundle.getString(key, defaultValue);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a boolean[] value, or null
     */
    @Nullable
    public boolean[] getBooleanArray(@Nullable String key) {
        return mBundle.getBooleanArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return an int[] value, or null
     */
    @Nullable
    public int[] getIntArray(@Nullable String key) {
        return mBundle.getIntArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a long[] value, or null
     */
    @Nullable
    public long[] getLongArray(@Nullable String key) {
        return mBundle.getLongArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a double[] value, or null
     */
    @Nullable
    public double[] getDoubleArray(@Nullable String key) {
        return mBundle.getDoubleArray(key);
    }

    /**
     * Returns the value associated with the given key, or null if
     * no mapping of the desired type exists for the given key or a null
     * value is explicitly associated with the key.
     *
     * @param key a String, or null
     * @return a String[] value, or null
     */
    @Nullable
    public String[] getStringArray(@Nullable String key) {
        return mBundle.getStringArray(key);
    }


}
