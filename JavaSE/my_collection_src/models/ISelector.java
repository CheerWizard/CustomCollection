package models;

public interface ISelector<TData> {
	<T> T select(TData data);
}
