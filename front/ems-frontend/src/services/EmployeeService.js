import axios from "axios" 

const REST_API_BASE_URL = 'http://localhost:8080/api/v1/employee'


export const listEmploees =() => axios.get(REST_API_BASE_URL)

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL, employee)
