import {Router} from "@vaadin/router";


const bodyElement = document.querySelector("main")
const router = new Router(bodyElement);

router.setRoutes([
    {
    path:"/",
    component: "home-page",
    action: async () => {
        await import("./pages/home-page.js");
        return true;
    },
},
    {
        path:"/retrieve",
        component: "retrieve-page",
        action: async () => {
            await import("./pages/retrieve-page.js");
            return true;
        }

    }
])
export {router};