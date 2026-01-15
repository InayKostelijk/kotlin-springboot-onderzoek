import { html, css, LitElement } from "lit";
import { expenseService } from "../shared/service/expense-service.js";

export class RetrievePage extends LitElement {

    static properties = {
        expenses: { type: Array }
    }

    // Add CSS
    static styles = css`
        :host {
            display: block;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            padding: 20px;
            background-color: #f5f5f5;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px 16px;
            text-align: left;
        }

        thead {
            background-color: #007bff;
            color: white;
        }

        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tbody tr:hover {
            background-color: #e6f0ff;
        }

        th {
            font-weight: bold;
        }
    `;

    constructor() {
        super();
        this.expenses = [];
    }

    async getAllexpenses() {
        try {
            this.expenses = await expenseService.getAllExpenses();
        } catch (err) {
            console.error("Failed to load expenses", err);
        }
    }

    connectedCallback() {
        super.connectedCallback();
        this.getAllexpenses();
    }

    render() {
        return html`
            <h2>Expenses</h2>
            <table>
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">User ID</th>
                    <th scope="col">Category</th>
                    <th scope="col">item</th>
                    <th scope="col">Price</th>
                    <th scope="col">Created At</th>
                </tr>
                </thead>
                <tbody>
                ${this.expenses.map(expense => html`
                    <tr>
                        <td>${expense.id}</td>
                        <td>${expense.userId}</td>
                        <td>${expense.category}</td>
                        <td>${expense.item}</td>
                        <td>€${expense.price}</td>
                        <td>${expense.createdAt}</td>
                    </tr>
                `)}
                </tbody>
            </table>
        `;
    }
}

window.customElements.define("retrieve-page", RetrievePage);
