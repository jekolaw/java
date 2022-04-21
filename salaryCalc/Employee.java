public class Employee {
        String nameSurname;
        int salary;
        int workHours;
        int hireYear;

        public Employee(String nameSurname, int salary, int workHours, int hireYear) {
            this.nameSurname = nameSurname;
            this.salary = salary;
            this.workHours = workHours;
            this.hireYear = hireYear;
        }

        public double tax() {
            if (this.salary > 1000) {
                return (this.salary * 0.03);
            }
            return 0;
        }

        public int bonus() {
            if (this.workHours > 40){
                return (this.workHours - 40) * 30;
            }
            return 0;
        }

        public double raiseSalary() {
            if (2021-this.hireYear < 10) {
                return (this.salary * 0.05);
            }
            else if (9 < 2021-this.hireYear && 2021-this.hireYear < 20) {
                return (this.salary * 0.1);
            }
            else {
                return (this.salary * 0.15);
            }
        }

        @Override
        public String toString() {
            return  "\nİsim Soyisim: " +this.nameSurname+
                    "\nMaaşı: "+this.salary+
                    "\nÇalışma Saati: "+this.workHours+
                    "\nBaşlangıç Yılı: "+this.hireYear+
                    "\nVergi: "+tax()+
                    "\nBonus: "+bonus()+
                    "\nMaaş Artışı: "+raiseSalary()+
                    "\nVergi ve Bonuslar ile birlikte maaş: "+(this.salary-tax()+bonus())+
                    "\nToplam Maaş: "+(this.salary-tax()+bonus()+raiseSalary());
        }
}
