package com.example.pujroutefinder.utils

import com.example.pujroutefinder.model.*

object RouteDataSource {
    fun getRoutes(): List<Route> {
        return listOf(
            Route(
                "01C",
                "01C - USC South Campus to Pier 3",
                "Route from USC South Campus through downtown Colon commercial district to Pier 3. Passes major landmarks including Gaisano Main, University of Visayas, and the Colon Obelisk.",
                listOf("USC South Campus", "Pier 3"),
                listOf(
                    Stop("USC South Campus", "School"), Stop("J Alcantara", "Landmark"),
                    Stop("Leon Kilat St", "Road"), Stop("Metro Colon", "Mall"),
                    Stop("Colonnade Supermarket", "Mall / Grocery"), Stop("Gaisano Main", "Mall"),
                    Stop("University of Visayas", "School"), Stop("Colon Obelisk", "Landmark"),
                    Stop("Mabini Street", "Road"), Stop("Zulueta Street", "Road"),
                    Stop("MJ Cuenca Ave", "Road"), Stop("Tiburcio Padilla Street", "Road"),
                    Stop("B Benedicto Street", "Road"), Stop("General Maxilom Ave Ext", "Road"),
                    Stop("Pier 4", "Terminal"), Stop("Pier 3", "Terminal")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("This is a loop route, so it can be used in both directions.", "Board near USC South Campus for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "01K",
                "01K - V Urgello Street to Parkmall",
                "Route from V Urgello Street through Colon, NSO, and SM City Cebu up to Parkmall.",
                listOf("V Urgello Street", "Parkmall"),
                listOf(
                    Stop("V Urgello Street", "Road"), Stop("Sacred Heart Hospital", "Health"),
                    Stop("Southwestern University", "School"), Stop("Elizabeth Mall (Emall)", "Mall / Grocery"),
                    Stop("Leon Kilat Street", "Road"), Stop("Colon", "Terminal"),
                    Stop("Metro Gaisano", "Mall"), Stop("Colonnade Supermarket", "Mall / Grocery"),
                    Stop("University of Visayas", "School"), Stop("Gaisano Main", "Mall"),
                    Stop("Brgy. Parian", "Landmark"), Stop("Zulueta Street", "Road"),
                    Stop("MJ Cuenca Ave", "Road"), Stop("National Statistics Office (NSO)", "Government"),
                    Stop("General Maxilom Ave", "Road"), Stop("A Soriano Ave", "Road"),
                    Stop("SM City Cebu", "Mall"), Stop("North Bus Terminal", "Terminal"),
                    Stop("Cebu Doctors University", "School"), Stop("CICC", "Landmark"),
                    Stop("Parkmall", "Mall / Terminal")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near V Urgello Street for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "02B",
                "02B - Cebu City Medical Center to Pier 3",
                "Essential route from South Bus Terminal through downtown Colon to the port area. Serves intercity travelers, hospital visitors, and port-bound commuters.",
                listOf("Cebu City Medical Center", "Pier 3"),
                listOf(
                    Stop("Cebu City Medical Center", "Health"), Stop("Cebu South Bus Terminal (CSBT)", "Terminal"),
                    Stop("Elizabeth Mall (Emall)", "Mall / Grocery"), Stop("Leon Kilat Street", "Road"),
                    Stop("Metro Colon", "Mall"), Stop("Colonnade Supermarket", "Mall / Grocery"),
                    Stop("University of Visayas (UV)", "School"), Stop("Gaisano Main", "Mall"),
                    Stop("University of Visayas", "School"), Stop("P Burgos Street", "Road"),
                    Stop("Legazpi Exit", "Landmark"), Stop("Pier 1", "Terminal"),
                    Stop("Pier 2", "Terminal"), Stop("Pier 3", "Terminal")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("This is a loop route, so it can be used in both directions.", "Board near Cebu City Medical Center for easy entry.")
            ),
            Route(
                "03A",
                "03A - F Cabahug Street to Carbon Public Market",
                "Residential to market route passing through Mabolo's business corridor and heritage landmarks. Stops at Museo Sugbo (Cebu provincial museum) and Cebu Technological University.",
                listOf("F Cabahug Street", "Carbon Public Market"),
                listOf(
                    Stop("F Cabahug Street", "Road"), Stop("Sykes Asia", "Landmark"),
                    Stop("Citi Park", "Landmark"), Stop("Sorroso International Hotel", "Hotel"),
                    Stop("Castle Peak Hotel", "Hotel"), Stop("Pope John Paul II Ave", "Road"),
                    Stop("PLDT", "Government"), Stop("Camelita Monastery", "Church / Religious"),
                    Stop("St Joseph Parish", "Church / Religious"), Stop("The Persimmon", "Landmark"),
                    Stop("Hipodromo", "Landmark"), Stop("Carreta Cemetery", "Landmark"),
                    Stop("Imus Ave", "Road"), Stop("Museo Sugbo", "Landmark"),
                    Stop("CPILS", "School"), Stop("Cebu Technological University", "School"),
                    Stop("Vicente Gullas Street", "Road"), Stop("Dionisio Jakosalem Street", "Road"),
                    Stop("Legaspi Street", "Road"), Stop("Progreso Street", "Road"),
                    Stop("Carbon Public Market", "Mall / Grocery")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near F Cabahug Street for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "03B",
                "03B - Sindulan Street to Metro Colon",
                "Alternative Mabolo route through Fuente Osmeña and Mango Avenue corridor. Passes USC North Campus, major residential towers, and Abellana Sports Complex.",
                listOf("Sindulan Street", "Metro Colon"),
                listOf(
                    Stop("Sindulan Street", "Road"), Stop("St Joseph Parish", "Church / Religious"),
                    Stop("The Persimmon", "Landmark"), Stop("Hipodromo", "Landmark"),
                    Stop("Carreta Cemetery", "Landmark"), Stop("USC North Campus", "School"),
                    Stop("Fooda Saversmart", "Mall / Grocery"), Stop("Horizons 101", "Landmark"),
                    Stop("Mango Square Mall", "Mall"), Stop("Fuente Osmeña Circle", "Landmark"),
                    Stop("Crown Regency Hotel", "Hotel"), Stop("Abellana Sports Complex", "Landmark"),
                    Stop("Social Security System (SSS)", "Government"), Stop("GV Tower Hotel", "Hotel"),
                    Stop("Metro Colon", "Mall")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near Sindulan Street for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "03L",
                "03L - P Cabantan to Carbon Public Market",
                "Route from P Cabantan through Mabolo and downtown Jakosalem corridor to Carbon Public Market.",
                listOf("P Cabantan", "Carbon Public Market"),
                listOf(
                    Stop("P Cabantan", "Road"), Stop("Waterfront Hotel", "Hotel"),
                    Stop("San Carlos Seminary Complex", "School"), Stop("PLDT", "Government"),
                    Stop("Camelita Monastery", "Church / Religious"), Stop("St Joseph Parish", "Church / Religious"),
                    Stop("The Persimmon", "Landmark"), Stop("Hipodromo", "Landmark"),
                    Stop("Carreta Cemetery", "Landmark"), Stop("Imus Ave", "Road"),
                    Stop("Museo Sugbo", "Landmark"), Stop("CPILS", "School"),
                    Stop("Tiburcio Padilla Street", "Road"), Stop("Commission on Audit (COA)", "Government"),
                    Stop("Cebu Technological University", "School"), Stop("Vicente Gullas Street", "Road"),
                    Stop("Dionisio Jakosalem Street", "Road"), Stop("Legaspi Street", "Road"),
                    Stop("Progreso Street", "Road"), Stop("Carbon Public Market", "Mall / Grocery")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near P Cabantan for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "03Q",
                "03Q - Ayala Center Cebu to SM City Cebu",
                "Short connector between Ayala Center Cebu and SM City Cebu via Juan Luna Avenue.",
                listOf("Ayala Center Cebu", "SM City Cebu"),
                listOf(
                    Stop("Ayala Center Cebu", "Mall"), Stop("Landers Superstore Cebu", "Mall / Grocery"),
                    Stop("Juan Luna Ave", "Road"), Stop("SM City Cebu", "Mall")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near Ayala Center Cebu for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "04B",
                "04B - Stephenson Street to Carbon Public Market",
                "Route from Lahug through Gorordo, Capitol, Fuente Osmeña, and City Hall corridor to Carbon Public Market.",
                listOf("Stephenson Street", "Carbon Public Market"),
                listOf(
                    Stop("Stephenson Street", "Road"), Stop("Salinas Drive", "Road"),
                    Stop("JY Square Mall", "Mall"), Stop("Sudlon", "Landmark"),
                    Stop("The Church of Jesus Christ of Latter-day Saints Temple", "Church / Religious"), Stop("Lahug Brgy Hall", "Government"),
                    Stop("University of the Philippines", "School"), Stop("Gorordo Ave", "Road"),
                    Stop("Escario Central Mall", "Mall"), Stop("Cebu Provincial Capitol", "Government"),
                    Stop("Cebu Doctors University Hospital", "Health"), Stop("Fuente Osmeña Circle", "Landmark"),
                    Stop("Robinsons Place", "Mall"), Stop("Crown Regency Hotel", "Hotel"),
                    Stop("Abellana Sports Complex", "Landmark"), Stop("USC Main Campus", "School"),
                    Stop("Colonnade Supermarket", "Mall / Grocery"), Stop("Legaspi Street", "Road"),
                    Stop("Cebu Metropolitan Cathedral", "Church / Religious"), Stop("Sto Nino Brgy Hall", "Government"),
                    Stop("Osmena Blvd", "Road"), Stop("Metropolitan Cebu Water District", "Government"),
                    Stop("La Nueva", "Landmark"), Stop("Cebu City Hall", "Government"),
                    Stop("Carbon Public Market", "Mall / Grocery")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near Stephenson Street for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "04H",
                "04H - Busay to Carbon Public Market",
                "Uphill route from Busay down through Lahug and Capitol area to Carbon Public Market.",
                listOf("Busay", "Carbon Public Market"),
                listOf(
                    Stop("Busay", "Landmark"), Stop("Cebu Veterans Drive", "Road"),
                    Stop("Marco Polo Hotel", "Hotel"), Stop("JY Square Mall", "Mall"),
                    Stop("Sudlon", "Landmark"), Stop("The Church of Jesus Christ of Latter-day Saints Temple", "Church / Religious"),
                    Stop("Lahug Brgy Hall", "Government"), Stop("University of the Philippines", "School"),
                    Stop("Harolds Hotel Cebu", "Hotel"), Stop("Escario Central Mall", "Mall"),
                    Stop("Cebu Provincial Capitol", "Government"), Stop("Cebu Doctors University Hospital", "Health"),
                    Stop("Fuente Osmeña Circle", "Landmark"), Stop("Robinsons Place", "Mall"),
                    Stop("Crown Regency Hotel", "Hotel"), Stop("Abellana Sports Complex", "Landmark"),
                    Stop("Social Security System (SSS)", "Government"), Stop("GV Tower Hotel", "Hotel"),
                    Stop("University of Cebu", "School"), Stop("Panganiban Street", "Road"),
                    Stop("Katipunan Lumber", "Landmark"), Stop("Carbon Public Market", "Mall / Grocery")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near Busay for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "04I",
                "04I - Busay to Carbon Public Market (via Progreso)",
                "Variant of 04H passing via Progreso Street before Carbon Public Market.",
                listOf("Busay", "Carbon Public Market"),
                listOf(
                    Stop("Busay", "Landmark"), Stop("Cebu Veterans Drive", "Road"),
                    Stop("Marco Polo Hotel", "Hotel"), Stop("JY Square Mall", "Mall"),
                    Stop("Sudlon", "Landmark"), Stop("The Church of Jesus Christ of Latter-day Saints Temple", "Church / Religious"),
                    Stop("Lahug Brgy Hall", "Government"), Stop("University of the Philippines", "School"),
                    Stop("Harolds Hotel Cebu", "Hotel"), Stop("Escario Central Mall", "Mall"),
                    Stop("Cebu Provincial Capitol", "Government"), Stop("Cebu Doctors University Hospital", "Health"),
                    Stop("Fuente Osmeña Circle", "Landmark"), Stop("Robinsons Place", "Mall"),
                    Stop("Crown Regency Hotel", "Hotel"), Stop("Abellana Sports Complex", "Landmark"),
                    Stop("Social Security System (SSS)", "Government"), Stop("GV Tower Hotel", "Hotel"),
                    Stop("University of Cebu", "School"), Stop("Panganiban Street", "Road"),
                    Stop("Katipunan Lumber", "Landmark"), Stop("Progreso Street", "Road"),
                    Stop("Carbon Public Market", "Mall / Grocery")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near Busay for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            ),
            Route(
                "04L",
                "04L - Lahug to SM City Cebu",
                "Route from Lahug through Gorordo and Cebu Business Park down to SM City Cebu.",
                listOf("Lahug", "SM City Cebu"),
                listOf(
                    Stop("Lahug", "Landmark"), Stop("JY Square Mall", "Mall"),
                    Stop("Sudlon", "Landmark"), Stop("The Church of Jesus Christ of Latter-day Saints Temple", "Church / Religious"),
                    Stop("Lahug Brgy Hall", "Government"), Stop("University of the Philippines", "School"),
                    Stop("Gorordo Ave", "Road"), Stop("The Golden Peak Hotel", "Hotel"),
                    Stop("Kuya J's Restaurant", "Landmark"), Stop("Cebu Parklane Hotel", "Hotel"),
                    Stop("Pag-ibig Fund Cebu Office", "Government"), Stop("Standard Chartered Bank", "Government"),
                    Stop("Insular Life Cebu Business Center", "Landmark"), Stop("Keppel Tower Cebu Business Park", "Landmark"),
                    Stop("Pope John Paul II Ave", "Road"), Stop("PLDT", "Government"),
                    Stop("Camelita Monastery", "Church / Religious"), Stop("St Joseph Parish", "Church / Religious"),
                    Stop("SM City Cebu", "Mall")
                ),
                FareEstimate(13, 4, "₱13 for the first 4km; additional fare applies per km beyond that."),
                listOf("Board near Lahug for easy entry.", "Say 'Lugar lang' or tap the rail when approaching your stop.")
            )
        )
    }
}