package util;

    public enum Grade {
        F("F", 0),
        D("D", 1),
        C("C", 2),
        B("B", 3),
        A("A", 4);


        private String letterGrade;
        private int numberGrade;

        Grade(String letterGrade, int numberGrade) {
            this.letterGrade = letterGrade;
            this.numberGrade = numberGrade;
        }

        public String getLetterGrade() {
            return letterGrade;
        }

        public void setLetterGrade(String letterGrade) {
            this.letterGrade = letterGrade;
        }

        public int getNumberGrade() {
            return numberGrade;
        }

        public void setNumberGrade(int numberGrade) {
            this.numberGrade = numberGrade;
        }

        @Override
        public String toString() {
            return "Grade " + letterGrade + " corresponds to number grade of " + numberGrade + ".";
        }
    }



