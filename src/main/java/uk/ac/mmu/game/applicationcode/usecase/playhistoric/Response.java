package uk.ac.mmu.game.applicationcode.usecase.playhistoric;

public class Response {

    private boolean success;

    Response(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return success ? "success" : "fail";
    }
}
