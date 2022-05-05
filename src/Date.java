/**
 * date類別
 */
public class Date {
    private int year;  //年
    private int month;  //月
    private int day;  //日

    /**
     * 日期建構子
     * @param year 設定年
     * @param month 設定月
     * @param day 設定日
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 年
     * @return回傳年
     */
    public int getYear() {
        return year;
    }

    /**
     * 月
     * @return回傳
     */
    public int getMonth() {
        return month;
    }

    /**
     * 日
     * @return回傳
     */
    public int getDay() {
        return day;
    }
}
