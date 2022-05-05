import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookShelf bookShelf = new BookShelf(new Book[1], 0); //初始化array
        boolean isContinue = true; //判斷程式進行
        while (isContinue) {
            showOption(); //介面顯示
            int option = sc.nextInt(); //使用者動作
            sc.nextLine();
            switch (option) {
                case 1:
                    addBook(sc, bookShelf);//新增一本書
                    break;
                case 2:
                    searchBookByAuthor(sc, bookShelf);//查詢指定作者所撰寫的書籍
                    break;
                case 3:
                    searchBookByName(sc, bookShelf);//查詢指定書名的詳細資料
                    break;
                case 4:
                    searchBookByDate(sc, bookShelf);//查詢指定出版日的書籍
                    break;
                case 5:
                    searchBookByDateArea(sc, bookShelf);//查詢指定日期期間的書籍
                    break;
                case 6:
                    isContinue = false; //結束
                    break;
            }
        }
    }

    /**
     * 查詢指定日期期間的書籍
     * @param sc 輸入
     * @param bookShelf 書櫃class
     */
    private static void searchBookByDateArea(Scanner sc, BookShelf bookShelf) {
        System.out.println("請輸入開始年:");
        int startYear = sc.nextInt();
        System.out.println("請輸入開始月");
        int startMonth = sc.nextInt();
        System.out.println("請輸入開始日");
        int startDay = sc.nextInt();
        Date startDate = new Date(startYear,startMonth,startDay); //創建開始日

        System.out.println("請輸入結束年:");
        int endYear = sc.nextInt();
        System.out.println("請輸入結束月");
        int endMonth = sc.nextInt();
        System.out.println("請輸入結束日");
        int endDay = sc.nextInt();
        Date endDate = new Date(endYear,endMonth,endDay); //創建結束日
        Book[] showBook = bookShelf.searchBookByDateArea(startDate,endDate); //查詢出版日

        if (showBook == null) { //判斷是否有資訊
            System.out.println("無符合書本");
        } else {
            for (int i = 0; i < showBook.length; i++) {
                System.out.println("出版日:" + showBook[i].getDate().getYear() + "年"
                        + showBook[i].getDate().getMonth() + "月"
                        + showBook[i].getDate().getDay() + "日"
                        +" 書名:" + showBook[i].getName()
                        + " 作者:" + showBook[i].getAuthor());
            }
        }
    }

    /**
     * 查詢指定出版日的書籍
     * @param sc 輸入
     * @param bookShelf 書櫃class
     */
    private static void searchBookByDate(Scanner sc, BookShelf bookShelf) {
        System.out.println("請輸入出版年:");
        int year = sc.nextInt();
        System.out.println("請輸入出版月");
        int month = sc.nextInt();
        System.out.println("請輸入出版日");
        int day = sc.nextInt();
        Date searchDate = new Date(year,month,day); //創建出版日
        Book[] showBook = bookShelf.searchBookByDate(searchDate); //查詢出版日

        if (showBook == null) { //判斷是否有資訊
            System.out.println("無符合書本");
        } else {
            for (int i = 0; i < showBook.length; i++) {
                System.out.println("出版日:" + showBook[i].getDate().getYear() + "年"
                        + showBook[i].getDate().getMonth() + "月"
                        + showBook[i].getDate().getDay() + "日"
                        +" 書名:" + showBook[i].getName()
                        + " 作者:" + showBook[i].getAuthor());
            }
        }
    }

    /**
     * 查詢指定書名的書籍
     * @param sc 輸入
     * @param bookShelf 書櫃class
     */
    private static void searchBookByName(Scanner sc, BookShelf bookShelf) {
        System.out.println("請輸入書名");
        String name = sc.nextLine();
        Book[] showBook = bookShelf.getByName(name); //查詢作者

        if (showBook == null) { //判斷是否有資訊
            System.out.println("無符合書本");
        } else {
            for (int i = 0; i < showBook.length; i++) {
                System.out.println("書名:" + showBook[i].getName()
                        + " 作者:" + showBook[i].getAuthor()
                        + " 出版日:" + showBook[i].getDate().getYear() + "年"
                        + showBook[i].getDate().getMonth() + "月"
                        + showBook[i].getDate().getDay() + "日");
            }
        }
    }

    /**
     * 查詢指定作者所撰寫的書籍
     *
     * @param sc 輸入
     * @param bookShelf 書櫃class
     */
    private static void searchBookByAuthor(Scanner sc, BookShelf bookShelf) {
        System.out.println("請輸入作者");
        String author = sc.nextLine();
        Book[] showBook = bookShelf.searchBookByAuthor(author); //查詢作者

        if (showBook == null) { //判斷是否有資訊
            System.out.println("無符合書本");
        } else {
            for (int i = 0; i < showBook.length; i++) {
                System.out.println("作者:" + showBook[i].getAuthor()
                        + " 書名:" + showBook[i].getName()
                        + " 出版日:" + showBook[i].getDate().getYear() + "年"
                        + showBook[i].getDate().getMonth() + "月"
                        + showBook[i].getDate().getDay() + "日");
            }
        }
    }

    /**
     * 新增書本於數櫃內
     *
     * @param sc 輸入
     * @param bookShelf 書櫃class
     */
    private static void addBook(Scanner sc, BookShelf bookShelf) {
        System.out.println("請輸入書名:");
        String name = sc.nextLine();
        System.out.println("請輸入作者");
        String author = sc.nextLine();
        System.out.println("請輸入出版年:");
        int year = sc.nextInt();
        System.out.println("請輸入出版月");
        int month = sc.nextInt();
        System.out.println("請輸入出版日");
        int day = sc.nextInt();

        Date bookDate = new Date(year, month, day); //創建出版日
        bookShelf.add(name, bookDate, author); //新增書本
    }

    /**
     * 顯示使用者介面
     */
    public static void showOption() {
        System.out.println("請選擇功能:");
        System.out.println("1.新增一本書");
        System.out.println("2.查詢指定作者所撰寫的書籍");
        System.out.println("3.查詢指定書名的詳細資料");
        System.out.println("4.查詢指定出版日的書籍");
        System.out.println("5.查詢指定日期期間的書籍");
        System.out.println("6.結束程式");
    }
}
