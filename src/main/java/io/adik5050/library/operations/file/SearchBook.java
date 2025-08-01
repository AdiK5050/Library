package io.adik5050.library.operations.file;

public class SearchBook {

    BookShelf bookShelfObj;

    public SearchBook() {
        this.bookShelfObj = new BookShelf();
    }

    public String searchingBook(String book) {
        if(book.trim().isEmpty()) return "Empty Book Name!";
        int matchFound = 0;
        String[] bookToSearchToken = book.trim().split("\\s+");

        for(String bookName : bookShelfObj.getBooks()) {
            if(bookName.trim().isEmpty()) continue;
            matchFound = 0;
            String[] bookNameToken = bookName.trim().split("\\s+");

            for(int i = 0; i < bookNameToken.length && i < bookToSearchToken.length; i++) {
                if(bookToSearchToken[i].equalsIgnoreCase(bookNameToken[i])) matchFound++;
            }

            if(matchFound > 1 && matchFound < bookToSearchToken.length) {
                System.out.println("Similar Match Found:- " + bookName);
            }

            else if(matchFound == bookToSearchToken.length){
                return "Match Found:- " + bookName;
            }
        }
        return "Exact Match Not Found!";
    }
}
