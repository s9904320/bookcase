/**
 * bookshelf類別
 */
 public class BookShelf {
     private Book[] books; //書array
     private int bookCount; //總數

    /**
     *書櫃建構子
     * @param books 書陣列
     * @param bookCount 總數
     */
    public BookShelf(Book[] books, int bookCount) {
        this.books = books;
        this.bookCount = bookCount;
    }

    /**
     * 查詢出版期間
     * @param startDate 開始日
     * @param endDate 結束日
     * @return 回傳Book陣列
     */
    public Book[] searchBookByDateArea(Date startDate, Date endDate){
        Book[] showBooks = new Book[bookCount]; //創建查詢陣列
        boolean haveData = false;   //是否有符合
        int start = startDate.getYear()*10000 + startDate.getMonth()*100 + startDate.getDay(); //開始日
        int end = endDate.getYear()*10000 + endDate.getMonth()*100 + endDate.getDay(); //結束日
        for(int i = 0; i < bookCount; i++){
            int check = books[i].getDate().getYear()*10000 + books[i].getDate().getMonth()*100 + books[i].getDate().getDay();//檢查日

            if(start <= check && end >= check){ //區間內
                showBooks[i] = books[i]; //給入書本資訊
                haveData = true;
            }
        }

        if(!haveData){
            return null;  //沒有資訊
        }else {
            return showBooks;  //符合資訊
        }
    }

    /**
     * 查詢出版日
     * @param searchDate 出版日
     * @return 回傳Book陣列
     */
    public Book[] searchBookByDate(Date searchDate){
        Book[] showBooks = new Book[bookCount]; //創建查詢陣列
        boolean haveData = false;   //是否有符合
        for(int i = 0; i < bookCount; i++){
            if(books[i].getDate().getYear() == searchDate.getYear() &&
                    books[i].getDate().getMonth() == searchDate.getMonth() &&
                    books[i].getDate().getDay() == searchDate.getDay()){
                showBooks[i] = books[i]; //給入書本資訊
                haveData = true;
            }
        }

        if(!haveData){
            return null;  //沒有資訊
        }else {
            return showBooks;  //符合資訊
        }
    }

    /**
     *查詢書名
     * @param name 書名
     * @return 回傳Book陣列
     */
    public Book[] getByName(String name){
        Book[] showBooks = new Book[bookCount]; //創建查詢陣列
        boolean haveData = false;   //是否有符合
        for(int i = 0; i < bookCount; i++){
            if(books[i].getName().equals(name)){
                showBooks[i] = books[i]; //給入書本資訊
                haveData = true;
            }
        }

        if(!haveData){
            return null;  //沒有資訊
        }else {
            return showBooks;  //符合資訊
        }
    }

    /**
     *查詢作者寫的書
     * @param author 作者
     * @return 回傳Book陣列
     */
    public Book[] searchBookByAuthor(String author){
        Book[] showBooks = new Book[bookCount]; //創建查詢陣列
        boolean haveData = false;   //是否有符合
        for(int i = 0; i < bookCount; i++){
            if(books[i].getAuthor().equals(author)){
                showBooks[i] = books[i]; //給入書本資訊
                haveData = true;
            }
        }

        if(!haveData){
            return null;  //沒有資訊
        }else {
            return showBooks;  //符合資訊
        }
    }

    /**
     * 新增書籍
     * @param name 新增書本名稱
     * @param date 新增書本出版日
     * @param author 新增書本作者
     */
    public void add(String name, Date date, String author){
        if (bookCount == books.length) { //判斷是否需要擴充
            books = doubleArr(books);
        }
        books[bookCount] = new Book(name,date,author); //新增書本
        bookCount++; //書本數量+1
    }

    /**
     * 擴充陣列空間
     * @param books 書本陣列
     * @return 回傳擴充完的陣列
     */
    public Book[] doubleArr(Book[] books) {
        Book[] newArr = new Book[books.length * 2];
        for (int i = 0; i < books.length; i++) {
            newArr[i] = books[i];
        }
        return newArr;
    }
}
