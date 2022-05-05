/**
 * book類別
 */
public class Book {
    private String name; //書名
    private Date date; //出版日期
    private String author; //作者

    /**
     * 建構子
     * @param name 書名
     * @param date 出版日
     * @param author 作者
     */
    public Book(String name, Date date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    /**
     * 取得作者
     * @return 回傳作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 取得書名
     * @return 回傳書名
     */
    public String getName() {
        return name;
    }

    /**
     * 取得出版日
     * @return 回傳出版日
     */
    public Date getDate() {
        return date;
    }
}
