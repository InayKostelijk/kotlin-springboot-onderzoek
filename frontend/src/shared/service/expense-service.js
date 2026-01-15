class ExpenseService {


    async createExpense(expense){
        try {

            const url = "http://172.167.175.183:8080/api/api/expenses"
            const resp = await fetch(url, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(expense),
            });
            const data = await resp.text();
            return {
                data
            }
        }
        catch (error) {
            console.log(error)
        }
    }
    async getAllExpenses(){
        try{
            const url = "http://172.167.175.183:8080/api/api/expenses"
            const resp = await fetch(url, {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                }
            })
            return await resp.json()
        }
        catch (error) {
            console.log(error)
        }
    }


}

const expenseService = new ExpenseService();
export { expenseService };
