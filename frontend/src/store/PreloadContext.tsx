import { createContext } from "react";
import { PreloadProps } from "../pages/vehicleEstimationPage/VehicleEstimationPage";

export const preloadContext = createContext<PreloadProps | null>(null);