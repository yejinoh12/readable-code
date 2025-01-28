package cleancode.minesweeper.tobe;

public class Cell {

    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";

    private int nearbyLandMineCount;
    private boolean isLandMine;
    private boolean isFlagged;
    private boolean isOpened;

    private Cell(int nearbyLandMineCount, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        this.nearbyLandMineCount = nearbyLandMineCount;
        this.isLandMine = isLandMine;
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    //정적팩토리 메서드를 사용하여 객체 생성
    //이름을 줄 수 있음
    public static Cell of(int nearbyLandMineCount, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        return new Cell(nearbyLandMineCount, isLandMine, isFlagged, isOpened);
    }

    //빈 셀 생성
    public static Cell create() {
        return of(0, false, false, false);
    }

    //지뢰 설정
    public void turnOnLandMine() {
        this.isLandMine = true;
    }

    //인근 지뢰 숫자
    //setter 개념이지만 메서드 명을 다르게
    public void updateNearbyLandMindCount(int count) {
        this.nearbyLandMineCount = count;
    }

    public void flag() {
        this.isFlagged = true;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isChecked() {
        return this.isFlagged || this.isOpened;
    }

    public boolean isLandMain() {
        return this.isLandMine;
    }
    public boolean isOpened() {
        return this.isOpened;
    }

    public boolean hasLandMineCount() {
        return this.nearbyLandMineCount != 0;
    }

    //Getter
    //깃발을 main 함수에서 갈아끼우는 것이 아니라
    //상태를 통해 Cell 에서 깃발을 관리함
    public String getSign() {
        if(isOpened){
            if(isLandMine) {
                return LAND_MINE_SIGN;
            }
            if(hasLandMineCount()){
                return String.valueOf(nearbyLandMineCount);
            }
            return EMPTY_SIGN;
        }

        if(isFlagged){
            return FLAG_SIGN;
        }

        return UNCHECKED_SIGN;
    }
}
