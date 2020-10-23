package tv.nosy.climanage.models.dao;

public interface ICodeDAO {
    public void addCode(Code cd);
    public Code getCode(long ref);
    public void updateCode(Code ref);
    public void removeCode(long ref);
}
