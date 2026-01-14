import { LitElement, html } from "lit";
import "../features/expenses/components/create-expense-inputs.js"
import"../shared/service/expense-service.js"
import {expenseService} from "../shared/service/expense-service.js";
export class HomePage extends LitElement {


    getFormData(event) {
        event?.preventDefault();
        const form = event.target;
        const formData = new FormData(form);
        return Object.fromEntries(formData);
    }
    async saveExpense(event){
        event.preventDefault()
        const document = this.getFormData(event);
        const raw = document.expense;
        const expense = JSON.parse(raw);
         await expenseService.createExpense(expense);
    }

    render() {
        return html`
        <form @submit=${this.saveExpense}>
            <create-expense-inputs name="expense"></create-expense-inputs>
            <input class="btn" type="submit" value="Opslaan" />
        </form>
        
    `;
    }
}

window.customElements.define("home-page", HomePage);
