/* eslint-disable max-lines-per-function */
import { html, LitElement, css } from "lit";


export class CreateAssignmentPageInputs extends LitElement {
    #internals;
    static formAssociated = true;

    static properties = {
        data: { Object },
        isEditDisabled: { Boolean },
    };

    constructor() {
        super();
        this.data = {
            title: "",
            titleDescription: "",
            areasOfInterest: "",
            problemStatement: "",
            description: "",
            clientContext: "",
            level: "",
        };
        this.isEditDisabled = false;
        this.#internals = this.attachInternals();
    }

    setPreloadedAttributesToFieldSet(data) {
        // convert to JSON and set it as the form value
        const stringJSON = JSON.stringify(data);

        this.value = stringJSON;
        this.#internals.setFormValue(stringJSON);
    }

    updated(changedProperties) {
        if (changedProperties.has("data")) {
            // Preload existing form data into form internals.
            // This ensures that when a user edits a assignment, the form fields are populated with existing values.
            // Without this, attempting to update the assignment would result in blank data.
            this.setPreloadedAttributesToFieldSet(this.data);
            this.setFieldsetValue();
        }
    }

    setFieldValue(event) {
        const fieldElement = event.target;
        if (!fieldElement.checkValidity()) {
            fieldElement.reportValidity();
        }
        this.data = { ...this.data, [fieldElement.name]: fieldElement.value };
        this.setFieldsetValue();
    }

    setFieldsetValue() {
        const fieldsetObject = this.fieldsetFields.reduce((acc, field) => {
            acc[field.name] = field.element.value;
            return acc;
        }, {});

        this.value = JSON.stringify(fieldsetObject);
        this.#internals.setFormValue(this.value);
        this.setFieldsetValidity();
    }

    setFieldsetValidity() {
        const isValid = this.fieldsetFields.every((field) =>
            field.element.checkValidity(),
        );
        const firstInvalidField = this.fieldsetFields.find(
            (field) => !field.element.checkValidity(),
        );

        const message = firstInvalidField
            ? firstInvalidField.element.validationMessage
            : "";
        const focus = firstInvalidField
            ? firstInvalidField.element
            : this.shadowRoot.querySelector("fieldset");

        this.#internals.setValidity(
            isValid ? {} : { customError: true },
            message,
            focus,
        );
    }
    firstUpdated() {
        this.fieldsetFields = [
            { name: "userId", element: this.shadowRoot.querySelector("#userId") },
            {
                name: "item",
                element: this.shadowRoot.querySelector("#item"),
            },
            {
                name: "category",
                element: this.shadowRoot.querySelector("#category"),
            },
            {
                name: "price",
                element: this.shadowRoot.querySelector("#price"),
            }
        ];
    }


    render() {
        return html`
<fieldset>
  <section  class="card">
    <label for="userId">Gebruiker</label>
    <input type="text" id="userId" name="userId" @input=${this.setFieldValue} placeholder="gebruiker invoeren"
    /></section>
    <section  class="card">
        <label for="item">item</label>
        <input type="text" id="item" name="item" @input=${this.setFieldValue} placeholder="item invoeren"
        /></section>
    <section  class="card">
        <label for="category">category</label>
        <input type="text" id="category" name="category" @input=${this.setFieldValue} placeholder="category invoeren"
        /></section>
    <section  class="card">
        <label for="price">price</label>
        <input type="text" id="price" name="price" @input=${this.setFieldValue} placeholder="price invoeren"
        /></section>
    
</fieldset>
`;
    }
}


customElements.define(
    "create-expense-inputs",
    CreateAssignmentPageInputs,
);
