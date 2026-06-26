const API_URL = "http://localhost:8081/api/v1";

export const productProvider = async (
    productData,
    variantProduct,
    //img
) => {

    const formData = new FormData();

    formData.append("managementDTOJson", JSON.stringify({
        name: productData.name,
        description: productData.description,
        model: productData.model,
        price: productData.price,
        category: productData.category,
        productVariantDTO: productData.variantProduct
    }));

    /*formData.append("productVariantDTOJson", JSON.stringify({
        color: variantProduct[0].color,
        size: variantProduct[0].size,
        quantity: variantProduct[0].quantity
    }));*/
    /*img.forEach(file => {
        formData.append("images", file);
    });*/

    const response = await fetch(`${API_URL}/shopSite/addproduct`, {
        method: "POST",
        credentials: "include",
        body: formData
    });

    if (!response.ok) {
        throw new Error("Nie dodano produktu!");
    }

    return response.json();
};