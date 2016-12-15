package fcas.ltoy.mf.com.digitlotterforecast.model;

import java.util.ArrayList;

/**
 * Created by bingmingli on 16/11/15.
 */

public class HallListInfo {
    private int residue;
    private String name;
    private String cycle;
    private ArrayList<HallDetailListInfo> list;

    public int getResidue() {
        return residue;
    }

    public void setResidue(int residue) {
        this.residue = residue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public ArrayList<HallDetailListInfo> getList() {
        return list;
    }

    public void setList(ArrayList<HallDetailListInfo> list) {
        this.list = list;
    }

    public class HallDetailListInfo{
        private String _id;
        private String issue;
        private ArrayList<String> numbers;
        private String luckyBlue;
        private String time;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getIssue() {
            return issue;
        }

        public void setIssue(String issue) {
            this.issue = issue;
        }

        public ArrayList<String> getNumbers() {
            return numbers;
        }

        public void setNumbers(ArrayList<String> numbers) {
            this.numbers = numbers;
        }

        public String getLuckyBlue() {
            return luckyBlue;
        }

        public void setLuckyBlue(String luckyBlue) {
            this.luckyBlue = luckyBlue;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
