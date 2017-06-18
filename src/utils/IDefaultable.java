package utils;

public interface IDefaultable<T extends Enum<T>> {
    T getDefaultValue();
}