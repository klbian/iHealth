
const take_medicine_array = [{
    id: "1",
    url: "/static/medicine/1.jpg",
    name: "999感冒灵",
    count: "1",
    unit: "袋",
    times: [{ time: "08:00" }, { time: "12:00" }, { time: "20:00" }],
    start_date: "2023-11-25",
    end_date: "2023-12-1",
    IS_open_remind: true,
    beizhu: "饭后服用"
}];

function getFormattedTimes(medicine) {
    return medicine.times.map((time) => time.time).join(", ");
}

export {
    take_medicine_array,
    getFormattedTimes
};
